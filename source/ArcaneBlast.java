import java.util.List;

public class ArcaneBlast implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        //prevent error
        if (source == null || targets == null || targets.isEmpty()) {
            return;
        }
        
        int attackerATK = source.getAttack();
        int kills = 0;
        
        // Deal damage to all targets and count kills
        for (Combatant target : targets) {
            if (target == null || !target.isAlive()) {
                continue;
            }
            
            int targetDEF = target.getDefense();
            int damage = Math.max(0, attackerATK - targetDEF);
            int hpBefore = target.getCurrentHP();
            
            target.takeDamage(damage);
            
            // Count kills
            if (hpBefore > 0 && !target.isAlive()) {
                kills++;
            }
        }
        
        // Apply attack buff for each kill (10 per kill )
        if (kills > 0) {
            int attackIncrease = kills * 10;
            AttackBuff buff = new AttackBuff(attackIncrease);
            source.addStatusEffect(buff);
        }
    }
}
