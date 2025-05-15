// SPDX-License-Identifier: MIT
import greenfoot.*;

public class Home extends World {

    public Home() {
        super(1000, 450, 1);
        prepare();
    }

    private void prepare() {
        Play play = new Play();
        addObject(play, 702, 205);
        play.setLocation(570, 260);
        play.setLocation(579, 180);
        play.setLocation(567, 182);
        play.setLocation(556, 182);
        Info info = new Info();
        addObject(info, 800, 246);
        info.setLocation(520, 306);
        info.setLocation(585, 311);
        info.setLocation(541, 328);
        info.setLocation(545, 328);
        info.setLocation(561, 330);
        info.setLocation(557, 329);
        info.setLocation(558, 330);
        info.setLocation(557, 324);
        Help help = new Help();
        addObject(help, 646, 273);
        help.setLocation(632, 271);
        help.setLocation(538, 252);
        help.setLocation(556, 252);
        Version version = new Version();
        addObject(version,927,204);
        version.setLocation(966,42);
        version.setLocation(917,39);
    }
}
