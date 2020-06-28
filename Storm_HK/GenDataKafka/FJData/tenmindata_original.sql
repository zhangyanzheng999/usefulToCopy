create table TenminData (  
	`DATASOURCE` string ,
	`FAN_NO` string ,
	`DATA_DATE` string,
	`FAN_STATUS` double,
	`WIND_SPEED` double comment '风速',
	`ROTOR_RS` double comment '电机转速',
	`RS` double comment '桨叶转速',
	`WIND_DIRECTION` double comment '风向',
	`YAW_ANGLE` double comment '偏航角度',
	`BOX_T` double comment '齿轮箱油温',
	`BOX_BEARING_T` double comment '齿轮箱轴承油温',
	`ENVIRON_T` double comment '环境温度',
	`WT_T` double comment '机舱温度',
	`ROTOR_GROUP_T` double  comment '发电机温度',
	`A_PHASE_C` double comment 'A相电流',
	`B_PHASE_C` double comment 'B相电流',
	`C_PHASE_C` double comment 'C相电流',
	`A_PHASE_V` double comment 'A相电压',
	`B_PHASE_V` double comment 'B相电压',
	`C_PHASE_V` double comment 'C相电压',
	`MACHINE_FREQUENCY` double comment '电机频率',
	`REACTIVE_POWER` double comment '无功功率',
	`POWER` double comment '有功功率',
	`POWER_FACTOR` double comment '功率因数',
	`TOTAL_POWER` double comment '总发电量',
	`TOTAL_GEN_TIME` double comment '总发电时间',
	`DOWN_TIME` double comment '故障时间',
	`STANDBY_TIME` double comment '备用时间',
	`REMARK` double comment '备注')
	PARTITIONED BY ( fc string,fj string)
	row format delimited fields terminated by ','
