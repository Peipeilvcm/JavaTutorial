package design_pattern;

abstract class Component{
    public abstract void operation();
}

class ConcreteComponent extends Component{
    @Override
    public void operation() {
        // 具体职责
    }
}

abstract class Decorator extends Component {
    protected Component component;

    public void setComponent(Component component){
        this.component = component;
    }

    @Override
    public void operation(){
        if(component != null){
            component.operation();
        }
    }
}

class ConcreteDecoratorA extends Decorator{
    private String addedState;
    @Override
    public void operation(){
        super.operation(); // 先运行原component的operation
        addedState = "New State"; // 再做A的operation
    }
}

class ConcreteDecoratorB extends Decorator{
    @Override
    public void operation(){
        super.operation();
        addbehavior();
    }

    private void addbehavior(){

    }
}

public class DecoratorTest{
    public static void exec(){
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();
    }
}


