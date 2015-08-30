/*
 * Copyright 2014 Attila Szegedi, Daniel Dekany, Jonathan Revusky
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package freemarker.core;

import java.util.TimeZone;

import freemarker.template.utility.DateUtil.CalendarFieldsToDateConverter;
import freemarker.template.utility.DateUtil.DateToISO8601CalendarFactory;
import freemarker.template.utility.DateUtil.TrivialCalendarFieldsToDateConverter;
import freemarker.template.utility.DateUtil.TrivialDateToISO8601CalendarFactory;

abstract class ISOLikeLocalTemplateDateFormatFactory extends LocalTemplateDateFormatFactory {
    
    private DateToISO8601CalendarFactory dateToCalenderFieldsCalculator;
    private CalendarFieldsToDateConverter calendarFieldsToDateConverter;

    public ISOLikeLocalTemplateDateFormatFactory(Environment env, TimeZone timeZone) {
        super(env, null, timeZone);
    }

    public DateToISO8601CalendarFactory getISOBuiltInCalendar() {
        DateToISO8601CalendarFactory r = dateToCalenderFieldsCalculator;
        if (r == null) {
            r = new TrivialDateToISO8601CalendarFactory();
            dateToCalenderFieldsCalculator = r;
        }
        return r;
    }

    public CalendarFieldsToDateConverter getCalendarFieldsToDateCalculator() {
        CalendarFieldsToDateConverter r = calendarFieldsToDateConverter;
        if (r == null) {
            r = new TrivialCalendarFieldsToDateConverter();
            calendarFieldsToDateConverter = r;
        }
        return r;
    }

    @Override
    protected void onLocaleChanged() {
        // No op
    }

    @Override
    protected void onTimeZoneChanged() {
        // No op
    }
    
}