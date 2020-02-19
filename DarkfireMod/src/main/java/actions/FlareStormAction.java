package actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

public class FlareStormAction extends AbstractGameAction {
  private boolean freeToPlayOnce = false;
  private int energyOnUse = -1;

  private DamageInfo.DamageType damageType;

  private AbstractPlayer p;
  private AbstractCreature m;
  private int damage;
  private int flameDraw;


  public FlareStormAction(AbstractPlayer p, AbstractCreature m, int damage, int flameDraw, DamageInfo.DamageType damageType, boolean freeToPlayOnce, int energyOnUse) {
    this.damageType = damageType;
    this.p = p;
    this.m = m;
    this.damage = damage;
    this.flameDraw = flameDraw;
    this.freeToPlayOnce = freeToPlayOnce;
    this.duration = Settings.ACTION_DUR_XFAST;
    this.actionType = AbstractGameAction.ActionType.SPECIAL;
    this.energyOnUse = energyOnUse;
  }


  public void update() {
    int effect = EnergyPanel.totalCount;
    if (this.energyOnUse != -1) {
      effect = this.energyOnUse;
    }

    if (this.p.hasRelic("Chemical X")) {
      effect += 2;
      this.p.getRelic("Chemical X").flash();
    }

    if (effect > 0) {
      for (int i = 0; i < effect; i++) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageType), AbstractGameAction.AttackEffect.FIRE));
        AbstractDungeon.actionManager.addToBottom(new GetFlames(p, flameDraw, false));
      }

      if (!this.freeToPlayOnce) {
        this.p.energy.use(EnergyPanel.totalCount);
      }
    }
    this.isDone = true;
  }
}