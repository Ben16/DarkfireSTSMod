package cards.flames;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BlueFlame extends AbstractFlameCard {
  private static final String ID = "darkfire:BlueFlame";
  private static final String NAME = "Blue Flame";
  private static final String IMG_PATH = "cards/flames/blue_flame.png";
  private static final int COST = 0;
  private static final String DESCRIPTION = "Gain 5 block. Exhaust. Ethereal.";
  private static final CardType TYPE = CardType.STATUS;
  private static final CardRarity RARITY = CardRarity.BASIC;
  private static final CardTarget TARGET = CardTarget.SELF;
  private static final int BLOCK = 6;

  public BlueFlame() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.block = this.baseBlock = BLOCK;
    this.exhaust = true;
    this.isEthereal = true;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
  }

  private static int UPGRADE_BLOCK = 3;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeBlock(UPGRADE_BLOCK);
    }
  }
}
