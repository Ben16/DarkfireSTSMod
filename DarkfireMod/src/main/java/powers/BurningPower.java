package powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import actions.GetFlames;
import character.DarkfireCharacter;

public class BurningPower extends AbstractDarkfirePower {
  public static final Logger logger = LogManager.getLogger(DarkfireCharacter.class.getName());
  public static final String POWER_ID = "darkfireMod:Burning";
  public static final String NAME = "Burning";
  public static String DESCRIPTIONS[];

  public BurningPower(AbstractCreature owner, int amount) {
    this.name = NAME;
    this.ID = POWER_ID;
    this.owner = owner;
    this.amount = amount;
    DESCRIPTIONS = new String[2];
    DESCRIPTIONS[0] = "Gain %d flame card per turn.";
    DESCRIPTIONS[1] = "Gain %d flame cards per turn.";

    if (this.amount >= 9999) {
      this.amount = 9999;
    }

    updateDescription();
    //load file when you have it
    loadIcon("burning"); // need to change this somehow
    this.type = AbstractPower.PowerType.BUFF;
    this.isTurnBased = true;
  }

  @Override
  public void atStartOfTurnPostDraw() {
    flash();
    AbstractDungeon.actionManager.addToBottom(new GetFlames(this.owner, this.amount, false));
  }

  @Override
  public void updateDescription() {
    if(amount == 1) {
      description = DESCRIPTIONS[0];
    } else if(amount > 1) {
      description = DESCRIPTIONS[1];
    }
    description = String.format(description, amount);
  }
}
