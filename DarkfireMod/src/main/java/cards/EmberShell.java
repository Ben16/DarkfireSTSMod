package cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class EmberShell extends AbstractDarkfireCard {

  private static final String ID = "darkfire:EmberShell";
  private static final String IMG_PATH = "cards/ember_shell.png";
  private static final int COST = 0;
  private static final CardType TYPE = CardType.SKILL;
  private static final CardRarity RARITY = CardRarity.COMMON;
  private static final CardTarget TARGET = CardTarget.ENEMY;
  private static final int BLOCK = 3;
  private static final int VULNERABLE = 1;

  public EmberShell() {
    super(ID, IMG_PATH, COST, TYPE, RARITY, TARGET);
    this.magicNumber = this.baseMagicNumber = VULNERABLE;
    this.block = this.baseBlock = BLOCK;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.GainBlockAction(p, p, this.BLOCK));
    AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new VulnerablePower(m, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
  }

  private static final int UPGRADE_BLOCK = 1;
  private static final int UPGRADE_VULNERABLE = 1;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      this.upgradeName();
      this.upgradeBlock(UPGRADE_BLOCK);
      this.upgradeMagicNumber(UPGRADE_VULNERABLE);
    }
  }
}
