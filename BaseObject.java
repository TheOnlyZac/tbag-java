class BaseObject {
    /**
     * BaseObject is the primitive for all object types in the game
     */

    public String name;

    public BaseObject(String name)
    {
        /**
         * Initialize a new BaseObject. Should never be used directly, only 
         * inherited.
         * 
         * @param name  The name of the object
         */
        this.name = name;
    }
}
