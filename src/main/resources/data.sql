--------------------------------------------------------
--  DDL for Table TO_TRADE_HOLIDAYS
--------------------------------------------------------
CREATE TABLE "TO_TRADE_CALENDARS" (
   "IDCALENDAR" NUMBER(10, 0) PRIMARY KEY,
   "NAME" VARCHAR2(40) NOT NULL
);
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TO_TRADE_HOLIDAYS
--------------------------------------------------------
CREATE TABLE "TO_TRADE_HOLIDAYS" (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   "IDCALENDAR" NUMBER(10, 0),
   "HOLIDAY" DATE NOT NULL,   
   FOREIGN KEY(IDCALENDAR) REFERENCES TO_TRADE_CALENDARS(IDCALENDAR)
);
--------------------------------------------------------
--  DDL for Index PK_TO_TRADE_CALENDARS
--------------------------------------------------------
--------------------------------------------------------
--  Constraints for Table TO_TRADE_CALENDARS
--------------------------------------------------------
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('35', 'INR');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('36', 'QAR');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('1', 'ARS');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('2', 'AED');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('3', 'AUD');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('4', 'BRL');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('5', 'CAD');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('6', 'CNH');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('7', 'CNY');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('8', 'CHF');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('9', 'CLP');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('10', 'COP');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('11', 'CZK');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('12', 'DKK');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('13', 'EUR');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('14', 'GBP');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('15', 'HKD');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('16', 'HUF');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('17', 'JPY');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('18', 'KWD');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('19', 'MAD');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('20', 'MXN');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('21', 'MYR');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('22', 'NOK');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('23', 'NZD');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('24', 'PEN');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('25', 'PLN');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('26', 'RON');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('27', 'RUB');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('28', 'SEK');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('29', 'SGD');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('30', 'TND');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('31', 'TRY');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('32', 'USD');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('33', 'ZAR');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('34', 'ZMK');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('86', 'SAR');
Insert into TO_TRADE_CALENDARS (IDCALENDAR, NAME)
values ('87', 'ILS');
commit;