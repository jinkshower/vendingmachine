## 자판기 프로그램
java로 이루어진 자판기 프로그램

### 목표

간단한 자판기 애플리케이션을 통해 추상화의 필요성을 깨닫는다.

### 요구사항

음료수는 콜라(500), 사이다(400), 닥터페퍼(600)가 있다.  
음료수의 종류, 가격은 변동될 수 있다.  
사용자는 자판기에 가진 돈을 입력한다.  
각 음료의 숫자를 입력하여 음료수를 구입할 수 있다.  
단위 테스트를 구현한다.  

### 리팩토링 포인트들

1. 음료수의 .drink() 메소드를 호출하면 "This is <name>"을 System.out.prinlnt()으로 출력하는 메서드를 테스트하려 했음
```java
@Test
void 이름으로_음료수를_반환_받을_수_있다() {
    //given
    String wanted = "Coke";

    //when
    Drink pop = vendingMachine.pop(wanted);

    //then
    pop.drink();//can't assert
}
```
io클래스를 사용하면 PrintStream을 테스트할 수 있지만 테스트가 복잡해질 것이라 생각했음.  
테스트 해야 할 것은 drink를 호출했을 때 원하는 메서드가 실행되는지라고 판단.(ui의 작동까지 테스트할 필요가 없다고 생각)
변경이 많을 거라 판단되는 ui부분을 인터페이스화 하여 Console로 두고 테스트에서는 MockConsole로 대체.

```java
public class MockConsole implements Console {
    private List<String> inputs = new ArrayList<>();

    @Override
    public String read() {
        return null;
    }

    @Override
    public void print(final String message) {
        inputs.add(message);
    }

    public List<String> getInputs() {
        return inputs;
    }
}

@Test
void 이름으로_음료수를_반환_받을_수_있다() {
    //given
    String wanted = "Coke";
    String expected = "This is Coke";

    //when
    Drink pop = vendingMachine.pop(wanted);
    String message = pop.drink();
    console.print(message);

    //then
    assertEquals(expected, console.getInputs().get(0));// can assert
}
```

2. 다른 종류의 음료수를 추가할때마다 익명 클래스를 작성해야 했음

```java
    @Test
    void 다른_종류의_음료수를_추가할_수_있다() {
        //given
        vendingMachine.add(new Drink("Lemonade", 800) {
            @Override
            public String drink() {
                return "This is Lemonade";
            }
        });// have to instantiate every time

        //when
        Map<Drink, Integer> store = vendingMachine.getStore();

        //then
        assertEquals(4, store.size());
    }
```
익명 클래스를 생성하는 구현을 내부로 숨기고 간편한 클라이언트 코드를 작성하고 싶었음.  
Drink 생성 코드를 인터페이스를 만들고, 이 인터페이스를 구현하는 클래스를 만들어서 사용.
Vending Machine 내의 add()에서 인터페이스를 매개변수로 받고 이 인터페이스의 작동 결과를 저장소에 더하는 걸로 바꿈  

```java
public void add(final DrinkGenerator drinkGenerator) {
    Drink drink = drinkGenerator.generate();
    store.put(drink, store.getOrDefault(drink, 0) + 1);
}

public class NameAndPriceGenerator implements DrinkGenerator {
    private final String name;
    private final int price;

    public NameAndPriceGenerator(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Drink generate() {
        return new Drink(name, price) {
            @Override
            public String drink() {
                return "This is " + name;
            }
        };
    }
}

-> vendingMachine.add(new NameAndPriceGenerator("Sprite", 700)); // light-weighted
```

3. Drink뿐만 아니라 Food도 파는 자판기로 구현하고 싶었음.  
 
Product 타입 하나로 Food, Drink 둘 다 구현체를 사용하기 위해 인터페이스로 선언.  
Product 인터페이스로만 두니 중복코드가 너무 많아서 Food, Drink는 추상 클래스로 다시 계층을 둠

```java
public interface Product {
    String getName();
    int getPrice();
    String consume();
}

public abstract class Drink implements Product {
    private final String name;
    private final int price;

    Drink(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String consume() {
        return "This is " + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
```
