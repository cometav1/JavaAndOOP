class Character {
    private String name;
    private int health;
    private int attackPower;
    private int mana;
    private int manaRegeneration;
    private int healthRegeneration;

    public Character(String name, int health, int attackPower, int mana, int manaRegeneration, int healthRegeneration) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.mana = mana;
        this.manaRegeneration = manaRegeneration;
        this.healthRegeneration = healthRegeneration;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    public int getManaRegeneration() {
        return manaRegeneration;
    }

    public int getHealthRegeneration() {
        return healthRegeneration;
    }

    public String getInfo() {
        return "Имя: " + name + ", Здоровье: " + health + ", Урон: " + attackPower +
                ", Мана: " + mana + ", Регенерация маны: " + manaRegeneration +
                ", Регенерация здоровья: " + healthRegeneration;
    }
}