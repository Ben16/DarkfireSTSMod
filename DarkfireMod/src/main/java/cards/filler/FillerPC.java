package cards.filler;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import cards.AbstractDarkfireCard;

public class FillerPC extends AbstractDarkfireCard {
  private static final String ID = "darkfire:FillerPC";
  private static final String IMG_PATH = "cards/filler.png";
  private static final int COST = 1;
  private static final CardType TYPE = CardType.POWER;
  private static final CardRarity RARITY = CardRarity.COMMON;
  private static final CardTarget TARGET = CardTarget.SELF;
  private static final int BLOCK = 1;

  public FillerPC() {
    super(ID, IMG_PATH, COST, TYPE, RARITY, TARGET);
    this.block = this.baseBlock = BLOCK;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new GainBlockAction(m, m, this.block));
  }

  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
    }
  }
}
