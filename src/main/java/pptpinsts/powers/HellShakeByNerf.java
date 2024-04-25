package pptpinsts.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static pptpinsts.BasicMod.makeID;

public class HellShakeByNerf extends AbstractPower {
    public static final String POWER_ID = makeID("HellShakeByNerf");
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;

    public HellShakeByNerf(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.loadRegion("sadistic");
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if (power.type == PowerType.DEBUFF && !power.ID.equals("Shackled") && !power.ID.equals(makeID("HellShake")) && source == this.owner && target != this.owner && !target.hasPower("Artifact")) {
            this.flash();
            addToBot(new ApplyPowerAction(target, source, new HellShake(target, source, this.amount), this.amount, AbstractGameAction.AttackEffect.POISON));
        }
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("HellShakeByNerf");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
