package cards.flames;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class YellowFlame extends AbstractFlameCard {
  private static final String ID = "darkfire:YellowFlame";
  private static final String NAME = "Yellow Flame";
  private static final String IMG_PATH = "cards/flames/yellow_flame.png";
  private static final int COST = 0;
  private static final String DESCRIPTION = "Gain 1 energy. Exhaust. Ethereal.";
  private static final CardType TYPE = CardType.STATUS;
  private static final CardRarity RARITY = CardRarity.BASIC;
  private static final CardTarget TARGET = CardTarget.SELF;
  private static final int ENERGY = 1;

  public YellowFlame() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.magicNumber = this.baseMagicNumber = ENERGY;
    this.exhaust = true;
    this.isEthereal = true;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new GainEnergyAction(this.magicNumber));
  }

  private static int UPGRADE_ENERGY = 1;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(UPGRADE_ENERGY);
    }
  }
}
