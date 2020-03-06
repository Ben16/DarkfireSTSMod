package cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Defend extends AbstractDarkfireCard {

  private static final String ID = "darkfire:Defend";
  private static final String IMG_PATH = "cards/defend.png";
  private static final int COST = 1;
  private static final CardType TYPE = CardType.SKILL;
  private static final CardRarity RARITY = CardRarity.BASIC;
  private static final CardTarget TARGET = CardTarget.SELF;
  private static final int BLOCK = 5;

  public Defend() {
    super(ID, IMG_PATH, COST, TYPE, RARITY, TARGET);
    this.block = this.baseBlock = BLOCK;
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
