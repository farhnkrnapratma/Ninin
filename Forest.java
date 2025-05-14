// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Forest extends World {

    public Forest() {
        super(1000, 450, 1);
        prepare();
    }

    private void prepare() {
        Hero hero = new Hero();
        addObject(hero, 157, 304);
        hero.setLocation(174, 336);
        hero.setLocation(198, 292);
    }
}
