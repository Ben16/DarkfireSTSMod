package actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class GetFlames extends AbstractGameAction {

  private AbstractPlayer player;
  private int number;
  private boolean distinct;
  private ArrayList<AbstractCard> flameCards;

  public GetFlames(AbstractCreature player, int number, boolean distinct) {
    this.player = (AbstractPlayer)player;
    this.number = number;
    this.distinct = distinct;
    this.flameCards = util.DarkfireCardList.GetAllFlameCards();
  }

  @Override
  public void update() {
    if (AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
      this.isDone = true;

      return;
    }

    for(int i = 0; i < number; ++i) {
      if(this.flameCards.size() == 0) {
        this.isDone = true;
        return;
      }
      int flameIndex = AbstractDungeon.cardRandomRng.random(this.flameCards.size() - 1);
      AbstractCard c = flameCards.get(flameIndex);
      this.player.hand.addToHand(c.makeCopy());
      if(this.distinct) {
        flameCards.remove(flameIndex);
      }
    }
    this.isDone = true;
    return;
  }
}
