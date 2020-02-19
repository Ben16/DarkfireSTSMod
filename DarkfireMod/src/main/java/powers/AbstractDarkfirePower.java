package powers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class AbstractDarkfirePower extends AbstractPower {
  protected void loadIcon(String path) {

    Texture tex32 = new Texture("powers/"+path+"_32.png");
    Texture tex84 = new Texture("powers/"+path+"_84.png");

    this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 32, 32);
    this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 84, 84);
  }
}
