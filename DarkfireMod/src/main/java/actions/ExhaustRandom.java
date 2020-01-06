package actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ExhaustRandom extends AbstractGameAction {

  private int number;
  private AbstractCreature src;
  private AbstractPlayer target;
  private static final float DURATION = Settings.ACTION_DUR_XFAST;

  public ExhaustRandom(AbstractCreature target, AbstractCreature src, int number) {
    this.target = (AbstractPlayer)target;
    this.src = src;
    this.number = number;
    setValues(target, src, number);
    this.duration = DURATION;
  }

  @Override
  public void update() {
    if (this.duration == DURATION) {
      if (AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
        this.isDone = true;

        return;
      }
      if (this.target.hand.size() <= this.amount) {
        this.amount = this.target.hand.size();
        int tmp = this.target.hand.size();

        for (int i = 0; i < tmp; i++) {
          AbstractCard c = this.target.hand.getTopCard();
          this.target.hand.moveToExhaustPile(c);
          //should add a trigger on exhaust
          //c.triggerOnManualDiscard();
        }

        AbstractDungeon.player.hand.applyPowers();
        tickDuration();

        return;
      }

      //do the random stuff
      for (int i = 0; i < this.amount; i++) {
        AbstractCard c = this.target.hand.getRandomCard(AbstractDungeon.cardRandomRng);
        this.target.hand.moveToExhaustPile(c);
        // exhaust trigger later
        //c.triggerOnManualDiscard();
      }
      tickDuration();
    }
    tickDuration();
  }
}
