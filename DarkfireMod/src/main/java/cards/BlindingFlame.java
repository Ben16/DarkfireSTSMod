package cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import actions.GetFlames;

public class BlindingFlame extends AbstractDarkfireCard {

  private static final String ID = "darkfire:BlindingFlame";
  private static final String NAME = "Blinding Flame";
  private static final String IMG_PATH = "cards/blinding_flame.png";
  private static final int COST = 2;
  private static final String DESCRIPTION = "Inflict 1 Weak on all enemies. Add 2 random flames to your hand.";
  private static final CardType TYPE = CardType.SKILL;
  private static final CardRarity RARITY = CardRarity.UNCOMMON;
  private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
  private static final int WEAK = 1;
  private static final int FLAME_DRAW = 2;

  public BlindingFlame() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.magicNumber = this.baseMagicNumber = WEAK;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
      AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(mo, p, new WeakPower(mo, this.magicNumber, false), this.magicNumber));
    }
    AbstractDungeon.actionManager.addToBottom(new GetFlames(p, FLAME_DRAW, false));
  }

  private static final int UPGRADE_WEAK = 1;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      this.upgradeName();
      this.upgradeMagicNumber(UPGRADE_WEAK);
    }
  }
}
