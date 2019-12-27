package cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class WheelingFlame extends AbstractDarkfireCard {
  private static final String ID = "darkfire:WheelingFlame";
  private static final String NAME = "Wheeling Flame";
  private static final String IMG_PATH = "cards/wheeling_flame.png";
  private static final int COST = 1;
  private static final String DESCRIPTION = "Deal 10 damage and draw 2 cards.";
  private static final CardType TYPE = CardType.ATTACK;
  private static final CardRarity RARITY = CardRarity.RARE;
  private static final CardTarget TARGET = CardTarget.ENEMY;
  private static final int DAMAGE = 10;
  private static final int CARD_DRAW = 2;

  public WheelingFlame() {
    super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, RARITY, TARGET);
    this.damage = this.baseDamage = DAMAGE;
    this.magicNumber = this.baseMagicNumber = CARD_DRAW;
  }

  @Override
  public void use(AbstractPlayer p, AbstractMonster m) {
    AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
    AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber));
  }

  private static int UPGRADE_DRAW = 1;
  @Override
  public void upgrade() {
    if (!this.upgraded) {
      upgradeName();
      upgradeMagicNumber(UPGRADE_DRAW);
    }
  }
}
