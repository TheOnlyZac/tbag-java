class BaseObject {
    /**
     * BaseObject is the primitive for all object types in the game
     */

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BaseObject(String name)
    {
        /**
         * Initialize a new BaseObject. Should never be used directly, only 
         * derived from.
         * 
         * @param name  The name of the object
         */
        this.name = name;
    }
}
