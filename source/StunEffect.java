/**
 * Stun status effect - prevents the combatant from taking actions.
 * Duration: 2 turns (current turn + next turn).
 */
public class StunEffect implements StatusEffect {
    private int duration;
    private static final String EFFECT_NAME = "Stun";
    
    public StunEffect() {
        // Initialize duration to 2 (current turn + next turn)
        this.duration = 2;
    }
    
    @Override
    public int getDuration() {
        // Return the current duration value
        return this.duration;
    }
    
    @Override
    public void decrementDuration() {
        // Check if duration is greater than 0
        if (duration > 0)
        {
            // If so, decrement duration by 1
            duration--;
        }
    }
    
    @Override
    public boolean isExpired() {
        // Return true if duration is less than or equal to 0, false otherwise
        return (duration <= 0);
    }
    
    @Override
    public void apply(Combatant combatant) {
        // Stun effect is passive - no active application needed
        // The canAct() method in Combatant checks for this effect
    }
    
    @Override
    public void remove(Combatant combatant) {
        // No cleanup needed
    }
    
    @Override
    public String getName() {
        // Return the predefined effect name constant
        return EFFECT_NAME;
    }
}
