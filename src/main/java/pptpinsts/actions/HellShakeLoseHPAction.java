package pptpinsts.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

import static pptpinsts.BasicMod.makeID;

public class HellShakeLoseHPAction extends AbstractGameAction {

    public HellShakeLoseHPAction(AbstractCreature target, AbstractCreature source, int amount, AbstractGameAction.AttackEffect effect) {
        setValues(target, source, amount);
        this.actionType = AbstractGameAction.ActionType.DAMAGE;
        this.attackEffect = effect;
        this.duration = 0.33F;
    }

    public void update() {
        if ((AbstractDungeon.getCurrRoom()).phase != AbstractRoom.RoomPhase.COMBAT) {
            this.isDone = true;
            return;
        }
        if (this.duration == 0.33F && this.target.currentHealth > 0)
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, this.attackEffect));
        tickDuration();
        if (this.isDone) {
            if (this.target.currentHealth > 0) {
                this.target.damage(new DamageInfo(this.source, this.amount, DamageInfo.DamageType.HP_LOSS));
                if (this.target.isDying) {
                    AbstractPlayer.poisonKillCount++;
                }
            }
            AbstractPower p = this.target.getPower(makeID("HellShake"));
            if (p != null) {
                p.amount--;
                if (p.amount == 0) {
                    this.target.powers.remove(p);
                } else {
                    p.updateDescription();
                }
            }
            if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead())
                AbstractDungeon.actionManager.clearPostCombatActions();
            addToTop((AbstractGameAction)new WaitAction(0.1F));
        }
    }
}