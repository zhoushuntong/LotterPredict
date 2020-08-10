package com.rigsec.lotteranalsis.dbdata;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 schemaVersion： 数据库schema版本，也可以理解为数据库版本号
 daoPackage：设置DaoMaster 、DaoSession、Dao包名
 targetGenDir：设置DaoMaster 、DaoSession、Dao目录
 targetGenDirTest：设置生成单元测试目录
 generateTests：设置自动生成单元测试用例
 4.）实体@Entity注解
 schema：告知GreenDao当前实体属于哪个schema
 active：标记一个实体处于活动状态，活动实体有更新、删除和刷新方法
 nameInDb：在数据中使用的别名，默认使用的是实体的类名
 indexes：定义索引，可以跨越多个列
 createInDb：标记创建数据库表
 5.）基础属性注解
 @Id :主键 Long型，可以通过@Id(autoincrement = true)设置自增长
 @Property：设置一个非默认关系映射所对应的列名，默认是的使用字段名 举例：@Property (nameInDb="name")
 @NotNul：设置数据库表当前列不能为空
 @Transient ：添加次标记之后不会生成数据库表的列
 6.)索引注解
 @Index：使用@Index作为一个属性来创建一个索引，通过name设置索引别名，也可以通过unique给索引添加约束
 @Unique：向数据库列添加了一个唯一的约束
 7.）关系注解
 @ToOne：定义与另一个实体（一个实体对象）的关系
 @ToMany：定义与多个实体对象的关系
 */
@Entity
public class BasicHistroyData {

    @Id(autoincrement = true)
    private long id;
    private int lotterType;
    private int first_number;
    private int second_number;
    private int three_number;
    private int four_number;
    private int five_number;
    private int six_number;
    private int seven_number;
    @Generated(hash = 178283313)
    public BasicHistroyData(long id, int lotterType, int first_number,
            int second_number, int three_number, int four_number, int five_number,
            int six_number, int seven_number) {
        this.id = id;
        this.lotterType = lotterType;
        this.first_number = first_number;
        this.second_number = second_number;
        this.three_number = three_number;
        this.four_number = four_number;
        this.five_number = five_number;
        this.six_number = six_number;
        this.seven_number = seven_number;
    }
    @Generated(hash = 2097223293)
    public BasicHistroyData() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getLotterType() {
        return this.lotterType;
    }
    public void setLotterType(int lotterType) {
        this.lotterType = lotterType;
    }
    public int getFirst_number() {
        return this.first_number;
    }
    public void setFirst_number(int first_number) {
        this.first_number = first_number;
    }
    public int getSecond_number() {
        return this.second_number;
    }
    public void setSecond_number(int second_number) {
        this.second_number = second_number;
    }
    public int getThree_number() {
        return this.three_number;
    }
    public void setThree_number(int three_number) {
        this.three_number = three_number;
    }
    public int getFour_number() {
        return this.four_number;
    }
    public void setFour_number(int four_number) {
        this.four_number = four_number;
    }
    public int getFive_number() {
        return this.five_number;
    }
    public void setFive_number(int five_number) {
        this.five_number = five_number;
    }
    public int getSix_number() {
        return this.six_number;
    }
    public void setSix_number(int six_number) {
        this.six_number = six_number;
    }
    public int getSeven_number() {
        return this.seven_number;
    }
    public void setSeven_number(int seven_number) {
        this.seven_number = seven_number;
    }
}
