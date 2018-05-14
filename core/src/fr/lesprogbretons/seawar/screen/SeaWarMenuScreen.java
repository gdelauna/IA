package fr.lesprogbretons.seawar.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import fr.lesprogbretons.seawar.screen.manager.GameMapManager;

import static fr.lesprogbretons.seawar.SeaWar.game;
import static fr.lesprogbretons.seawar.SeaWar.seaWarController;

/**
 * Classe qui permet d'afficher un menu
 * <p>
 * Inspiré par PixelScientists
 */
public class SeaWarMenuScreen extends ScreenAdapter {

    @Override
    public void show() {
        //Change here if window is too big for your screen
        //Needs to be the same ratio
        Gdx.graphics.setWindowedMode(800, 480);
        seaWarController.nouvellePartie();

        game.setScreen(new SeaWarMapScreen(new GameMapManager()));
    }
}
