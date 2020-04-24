package relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import actions.GetFlames;

public class DarkwoodTinder extends AbstractDarkfireRelic {
  private static final String ID = "darkfire:DarkwoodTinder";
  private static final Texture texture = new Texture("relics/darkwoodTinder.png");
  private static final int FLAME_DRAW = 2;

  public DarkwoodTinder() {
    super(ID, texture, RelicTier.STARTER, LandingSound.FLAT);
  }

  @Override
  public void atBattleStart() {
    AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
    AbstractDungeon.actionManager.addToBottom(new GetFlames(AbstractDungeon.player, FLAME_DRAW, false));
  }

  @Override
  public AbstractRelic makeCopy() {
    return new DarkwoodTinder();
  }
}
