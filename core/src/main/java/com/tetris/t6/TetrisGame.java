package com.tetris.t6;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import space.earlygrey.shapedrawer.ShapeDrawer;

/**
 * The type Tetris game.
 */
public final class TetrisGame extends Game {
    /**
     * Batch used by ShapeDrawer.
     */
    public PolygonSpriteBatch batch;
    /**
     *  Object used by the shape drawer to render a shape
     */
    private Texture texture;
    /**
     * The Font.
     */
    public BitmapFont font;
    /**
     * The Camera.
     */
    public OrthographicCamera camera;
    /**
     * The Viewport.
     */
    public Viewport viewport;
    /**
     * The object used to draw the board and pieces.
     */
    public ShapeDrawer drawer;
    /**
     * Object used by the shape drawer to set a pixel start point
     */
    private Pixmap pixmap;


    @Override
    public void create() {
        batch = new PolygonSpriteBatch();
        // Use LibGDX's default Arial font.
        font = new BitmapFont();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(),
            Gdx.graphics.getHeight());
        viewport = new ScreenViewport(camera);

        pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.drawPixel(0, 0);

        texture = new Texture(pixmap);
        final TextureRegion region = new TextureRegion(texture, 0, 0, 1, 1);
        drawer = new ShapeDrawer(batch, region);

        this.setScreen(new MenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        pixmap.dispose();
        texture.dispose();
    }
}
