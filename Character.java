import java.util.*;
public class Character{
    private int Strength;
    private int Dexterity;
    private int Constitution;
    private int Intelligence;
    private int Wisdom;
    private int Charisma;
    private String name;
    private boolean isMulticlassed;
    private ClassBase primaryClass;
    private ArrayList<ClassBase> classes = new ArrayList<>(); 
    private int level = 0;
    private int hitPoints;
    private int maxHitPoints;
    private int tempHitPoints;
    public boolean rollHP = false;
    /**
     * Creates the character
     */
    public Character(){
        Strength = rollStat();
        Dexterity = rollStat();
        Constitution = rollStat();
        Intelligence = rollStat();
        Wisdom = rollStat();
        Charisma = rollStat();
        name = "unknown";
    }
    public Character(int str, int dex, int con, int intel, int wis, int cha){
        Strength = str;
        Dexterity = dex;
        Constitution = con;
        Intelligence = intel;
        Wisdom = wis;
        Charisma = cha;
        name = "unknown";
    }
    public Character(int str, int dex, int con, int intel, int wis, int cha, String name){
        Strength = str;
        Dexterity = dex;
        Constitution = con;
        Intelligence = intel;
        Wisdom = wis;
        Charisma = cha;
        this.name = name;
    }
    public Character(String DBinput){
        //TODO: Create the format to input and output the character from the DB
    }
    public int getStrength(){
        return Strength;
    }
    public int getDexterity(){
        return Dexterity;
    }
    public int getConstitution(){
        return Constitution;
    }
    public int getInteligence(){
        return Intelligence;
    }
    public int getWisdom(){
        return Wisdom;
    }
    public int getCharisma(){
        return Charisma;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public void modifyStrength(int mod){
        this.Strength += mod;
    }
    public void modifyDexterity(int mod){
        this.Dexterity += mod;
    }
    public void modifyConstitution(int mod){
        this.Constitution += mod;
    }
    public void modifyIntelligence(int mod){
        this.Intelligence += mod;
    }
    public void modifyWisdom(int mod){
        this.Wisdom += mod;
    }
    public void modifyCharisma(int mod){
        this.Charisma += mod;
    }
    public int getMod(attributes attribute){
        int work = 0;
        switch(attribute){
            case Strength:
                work = this.Strength;
            break;
            case Dexterity:
                work = this.Dexterity;
            break;
            case Constitution:
                work = this.Constitution;
            break;
            case Intelligence:
                work = this.Intelligence;
            break;
            case Wisdom:
                work = this.Wisdom;
            break;
            case Charisma:
                work = this.Charisma;
            break;
        }
        switch(work){
            case 1:
                return -5;
            case 2: case 3:
                return -4;
            case 4: case 5:
                return -3;
            case 6: case 7:
                return -2;
            case 8: case 9:
                return -1;
            case 10: case 11:
                return 0;
            case 12: case 13:
                return 1;
            case 14: case 15:
                return 2;
            case 16: case 17:
                return 3;
            case 18: case 19:
                return 4;
            case 20: case 21:
                return 5;
            case 22: case 23:
                return 6;
            case 24: case 25:
                return 7;
            case 26: case 27:
                return 8;
            case 28: case 29:
                return 9;
            case 30:
                return 10;
            default:
                return 0;
        }
    }
    public void addClass(ClassBase classAdded){
        classes.add(classAdded);
        level += classAdded.getLevel();
        if(classes.size() == 1){
            primaryClass = classAdded;
            maxHitPoints = classAdded.getTypeOfHitDice() + getMod(attributes.Constitution);
            if(classAdded.getLevel() != 1){
                if(rollHP)
                    maxHitPoints = Tools.roll(classAdded.getLevel() - 1, classAdded.getTypeOfHitDice());
                else
                    maxHitPoints = (classAdded.getLevel() - 1) * Math.ceil((1+classAdded.getTypeOfHitDice())/2);
            }
        } else {
            if(rollHP)
                maxHitPoints = Tools.roll(classAdded.getLevel(), classAdded.getTypeOfHitDice());
            else
                maxHitPoints = classAdded.getLevel() * Math.ceil((1+classAdded.getTypeOfHitDice())/2);
        }
        hitPoints = maxHitPoints;
    }
    public int takeDamage(int amountOfDamage){
        int currentHP = hitPoints;
        hitPoints -= (amountOfDamage - tempHitPoints);
        if(hitPoints > currentHP){
            tempHitPoints = hitPoints - currentHP;
            hitPoints = currentHP
        }
        if(hitPoints < 0){
            hitPoints = 0;
        }
        return hitPoints
    } 
    public int heal(int amountOfHealing){
        hitPoints += amountOfHealing;
        if(hitPoints > maxHitPoints){
            hitPoints = maxHitPoints;
        }
        return hitPoints;
    }
    public int getHealth(){
        return hitPoints
    }
    public int getMaxHealth(){
        return maxHitPoints;
    }
    public int alterMaxHealth(int amountToAlter){
        maxHitPoints += amountToAlter;
        return maxHitPoints;
    }
    public int getTempHP(){
        return tempHitPoints;
    }
    public void addTempHP(int amountToAdd){
        tempHitPoints += amountToAdd;
    }
    public void removeClass(ClassBase classRemoved){
        classes.remove(classRemoved);
        level -= classRemoved.getLevel();
    }
    
    public String outputToDB(){
        //TODO: Create the format to input and output the character from the DB
        return "";
    }
    private int rollStat(){
        int dice1 = Tools.roll(1, 6);
        int dice2 = Tools.roll(1, 6);
        int dice3 = Tools.roll(1, 6);
        int dice4 = Tools.roll(1, 6);
        int min1 = Math.min(dice1, dice2);
        int min2 = Math.min(dice3, dice4);
        return dice1 + dice2 + dice3 + dice4 - Math.min(min1, min2);
    }
}
