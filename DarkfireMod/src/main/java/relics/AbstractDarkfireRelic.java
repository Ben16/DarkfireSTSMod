package relics;

import com.badlogic.gdx.graphics.Texture;

import basemod.abstracts.CustomRelic;

public abstract class AbstractDarkfireRelic extends CustomRelic {
  public AbstractDarkfireRelic(String id, Texture texture, RelicTier tier, LandingSound sfx) {
    super(id, texture, tier, sfx);
  }
}
