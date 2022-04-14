package de.murmelmeister.itemedit;

public final class ItemEdit extends Main {

    private static ItemEdit instance;

    @Override
    public void onDisable() {
        handleDisableMessage();
    }

    @Override
    public void onEnable() {
        init();
        handleEnableMessage();
    }

    @Override
    public void onLoad() {
        setInstance(this);
    }

    @Override
    public void init() {

    }

    public static ItemEdit getInstance() {
        return instance;
    }

    public static void setInstance(ItemEdit instance) {
        ItemEdit.instance = instance;
    }

}
