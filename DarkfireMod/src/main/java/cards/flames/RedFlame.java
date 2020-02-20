package cards.flames;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class RedFlame extends AbstractFlameCard {
  private static final String ID = "darkfire:RedFlame";
  private static final String NAME = "Red Flame";
  private static final String IMG_PATH = "cards/flames/red_flame.png";
  private static final int COST = 0;
  private static final String DESCRIPTION = "Inflict 1 Vulnerable. Exhaust. Ethereal.";
  private static final CardType TYPE = CardType.STATUS;
  private static final CardRarity RARITY = CardRarity.BASIC;
  private static final CardTarget TARGET = CardTarget.ENEMY;
  private static final int VULNERABLE = 1;

  public RedFlame() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.magicNumber = this.baseMagicNumber = VULNERABLE;
    this.exhaust = true;
    this.isEthereal = true;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new VulnerablePower(m, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.FIRE));  }

  private static int UPGRADE_VULNERABLE = 1;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(UPGRADE_VULNERABLE);
    }
  }
}
