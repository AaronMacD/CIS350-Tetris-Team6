package com.tetris.t6;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Screen that appears when the player loses.
 */
public final class LossScreen implements Screen {

    /**
     * Instance of the game.
     */
    private final TetrisGame game;
    /**
     * Glyphlayout allows us to get the width of whatever text we pass to it.
     */
    private final GlyphLayout gl = new GlyphLayout();
    /**
     * String for which player lost.
     */
    private final String loserText;
    /**
     * Instructions for quitting.
     */
    private static String menuText1 = "Press escape to quit";
    /**
     * Instructions for returning to main menu.
     */
    private static String menuText2 = "Or press any other key to return to"
                                    + " the main menu";
    /**
     * Background image for the loss screen.
     */
    private final Texture background;

    /**
     * Instantiates a new Loss screen.
     *
     * @param aGame  the a game
     * @param loser the player number that lost (1 or 2)
     */
    public LossScreen(final TetrisGame aGame, final int loser) {
        this.game = aGame;
        background = new Texture(Gdx.files.internal("bg_loss.png"));
        loserText = String.format("Player %d has lost!!!!", loser);
    }

    @Override
    public void render(final float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        gl.setText(game.font, loserText);
        final float w0 = gl.width;
        gl.setText(game.font, menuText1);
        final float w1 = gl.width;
        gl.setText(game.font, menuText2);
        final float w2 = gl.width;


        game.batch.begin();
        game.batch.draw(background, 0, 0);
        game.font.draw(game.batch, loserText,
            (Gdx.graphics.getWidth() - w0) / 2, 750);
        game.font.draw(game.batch, menuText1,
            (Gdx.graphics.getWidth() - w1) / 2, 150);
        game.font.draw(game.batch, menuText2,
            (Gdx.graphics.getWidth() - w2) / 2, 135);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new MenuScreen(this.game));
        }
    }

    @Override
    public void resize(final int width, final int height) {
        //game.viewport.update(width, height);
    }

    @Override
    public void pause() {
        //unused
    }

    @Override
    public void resume() {
        //unused
    }

    @Override
    public void show() {
            Gdx.graphics.setWindowedMode(650, Gdx.graphics.getHeight());
            game.camera.setToOrtho(false, Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
            game.camera.update();
            game.batch.setProjectionMatrix(game.camera.combined);

    }

    @Override
    public void hide() {
        //unused
    }

    @Override
    public void dispose() {
        //unused
    }
}
