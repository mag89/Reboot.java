// ships.launched >= 1922 && classes.displacement > 35_000 && classes.type='bb'

select ships.name from classes join ships on classes.class=ships.class where ships.launched >= 1922 and classes.displacement > 35000 and classes.type='bb'