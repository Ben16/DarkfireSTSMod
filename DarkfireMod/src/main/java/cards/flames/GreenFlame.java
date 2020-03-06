package cards.flames;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

public class GreenFlame extends AbstractFlameCard {
  private static final String ID = "darkfire:GreenFlame";
  private static final String IMG_PATH = "cards/flames/green_flame.png";
  private static final int COST = 0;
  private static final CardType TYPE = CardType.STATUS;
  private static final CardRarity RARITY = CardRarity.BASIC;
  private static final CardTarget TARGET = CardTarget.ENEMY;
  private static final int WEAK = 1;

  public GreenFlame() {
    super(ID, IMG_PATH, COST, TYPE, RARITY, TARGET);
    this.magicNumber = this.baseMagicNumber = WEAK;
    this.exhaust = true;
    this.isEthereal = true;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.FIRE));  }

  private static int UPGRADE_WEAK = 1;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(UPGRADE_WEAK);
    }
  }
}
