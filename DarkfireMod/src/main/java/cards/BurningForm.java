package cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import powers.BurningPower;

public class BurningForm extends AbstractDarkfireCard {
  private static final String ID = "darkfire:BurningForm";
  private static final String IMG_PATH = "cards/blaze.png";
  private static final int COST = 3;
  private static final CardType TYPE = CardType.POWER;
  private static final CardRarity RARITY = CardRarity.RARE;
  private static final CardTarget TARGET = CardTarget.SELF;
  private static final int FLAME_COUNT = 1;

  public BurningForm() {
    super(ID, IMG_PATH, COST, TYPE, RARITY, TARGET);
    this.magicNumber = this.baseMagicNumber = FLAME_COUNT;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    //need to make status effect with gain card each turn
    AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new BurningPower(AbstractDungeon.player, this.magicNumber), this.magicNumber, true, AbstractGameAction.AttackEffect.FIRE));

  }

  private static int REDUCE_COST = -1;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      updateCost(REDUCE_COST);
    }
  }
}
