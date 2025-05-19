public abstract class ClassBase{
    int level;
    int typeOfHitDice;
    public int getLevel(){
        return level;   
    }
    public void setLevel(int level){
        this.level = level;
    }
    public int getTypeOfHitDice(){
        return typeOfHitDice;
    }
    public abstract String levelAbilityDesc1();
    public abstract String levelAbilityDesc2();
    public abstract String levelAbilityDesc3();
    public abstract String levelAbilityDesc4();
    public abstract String levelAbilityDesc5();
    public abstract String levelAbilityDesc6();
    public abstract String levelAbilityDesc7();
    public abstract String levelAbilityDesc8();
    public abstract String levelAbilityDesc9();
    public abstract String levelAbilityDesc10();
    public abstract String levelAbilityDesc11();
    public abstract String levelAbilityDesc12();
    public abstract String levelAbilityDesc13();
    public abstract String levelAbilityDesc14();
    public abstract String levelAbilityDesc15();
    public abstract String levelAbilityDesc16();
    public abstract String levelAbilityDesc17();
    public abstract String levelAbilityDesc18();
    public abstract String levelAbilityDesc19();
    public abstract String levelAbilityDesc20();
    public abstract void inputFromDB();
    public abstract void outputToDB();
}
