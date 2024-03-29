package com.tetris.t6;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * The type Menu screen.
 */
public final class MenuScreen implements Screen {
    /**
     * Instance of the game.
     */
    private final TetrisGame game;
    /**
     * Glyphlayout allows us to get the width of whatever text we pass to it.
     */
    private final GlyphLayout gl = new GlyphLayout();
    /**
     * String to hold the text displayed on screen.
     */
    private static String menuText1 = "Press 1 for Single Player or 2 for "
                                    + "Versus! Or press Escape to quit";
    /**
     * Darryl's custom made logo for our game.
     */
    private final Texture logo;
    /**
     * Background image for the loss screen.
     */
    private final Texture background;

    /**
     * Instantiates a new Menu screen.
     *
     * @param aGame the game
     */
    public MenuScreen(final TetrisGame aGame) {
        this.game = aGame;

        logo = new Texture(Gdx.files.internal("LOGO.png"));
        background = new Texture(Gdx.files.internal("bg_menu.png"));
    }

    @Override
    public void render(final float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        game.camera.update();
        game.batch.setProjectionMatrix(game.camera.combined);

        final float w1 = logo.getWidth();

        gl.setText(game.font, menuText1);
        final float w2 = gl.width;


        game.batch.begin();
        game.batch.draw(background, 0, 0);

        game.batch.draw(logo, (Gdx.graphics.getWidth() - w1) / 2, 600);
        game.font.draw(game.batch, menuText1,
            (Gdx.graphics.getWidth() - w2) / 2, 440);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            game.setScreen(new GameScreen(game, 1));
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            game.setScreen(new GameScreen(game, 2));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(final int width, final int height) {
        game.viewport.update(width, height);
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
        //Main menu music can go here
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
