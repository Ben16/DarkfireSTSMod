package cards.filler;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import cards.AbstractDarkfireCard;

public class FillerSR extends AbstractDarkfireCard {
  private static final String ID = "darkfire:FillerSR";
  private static final String NAME = "Filler";
  private static final String IMG_PATH = "cards/filler.png";
  private static final int COST = 1;
  private static final String DESCRIPTION = "Filler text.";
  private static final CardType TYPE = CardType.SKILL;
  private static final CardRarity RARITY = CardRarity.RARE;
  private static final CardTarget TARGET = CardTarget.SELF;
  private static final int BLOCK = 1;

  public FillerSR() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
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