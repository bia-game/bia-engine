package engine.render;

import engine.model.RawModel;
import engine.model.TexturedModel;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

/**
 * @author Arthur Asatryan
 * @since 2/12/17 4:09 PM
 */
public class Renderer {

    public void prepare() {
        GL11.glClearColor(0.33F, 0.33F, 0.33F, 1);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    public void render(final TexturedModel texturedModel) {
        final RawModel model = texturedModel.getRawModel();
        GL30.glBindVertexArray(model.getVaoId());
        GL20.glEnableVertexAttribArray(0);
        GL20.glEnableVertexAttribArray(1);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturedModel.getTexture().getTextureId());
        GL11.glDrawElements(GL11.GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
        GL20.glDisableVertexAttribArray(0);
        GL20.glDisableVertexAttribArray(1);
        GL30.glBindVertexArray(0);
    }

}