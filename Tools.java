import java.util.*;
public class Tools{
    public static int roll(int amount, int type){
        return amount*(int)Math.floor(Math.random()*type)+1;
    }
}

enum attributes {
    Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma
}
