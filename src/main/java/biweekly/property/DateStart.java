package biweekly.property;

import java.util.Date;

import biweekly.util.DateTimeComponents;

/*
 Copyright (c) 2013, Michael Angstadt
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are met: 

 1. Redistributions of source code must retain the above copyright notice, this
 list of conditions and the following disclaimer. 
 2. Redistributions in binary form must reproduce the above copyright notice,
 this list of conditions and the following disclaimer in the documentation
 and/or other materials provided with the distribution. 

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * <p>
 * Defines the date that an event, free/busy component, or timezone component
 * starts.
 * </p>
 * <p>
 * <b>Examples:</b>
 * 
 * <pre class="brush:java">
 * //date and time
 * Date datetime = ...
 * DateStart dtstart = new DateStart(datetime);
 * 
 * //date
 * Date date = ...
 * DateStart dtstart = new DateStart(date, false);
 * 
 * //local date and time (don't print a timezone)
 * Date datetime = ...
 * DateStart dtstart = new DateStart(datetime);
 * dtstart.setLocalTime(true);
 * 
 * //with timezone 
 * Date datetime = ... 
 * DateStart dtstart = new DateStart(datetime); 
 * dtstart.setTimezoneId("America/New_York");
 * 
 * //raw components 
 * DateTimeComponents components = new DateTimeComponents(1999, 4, 4, 2, 0, 0, false);
 * DateStart dtstart = new DateStart(components);
 * </pre>
 * 
 * </p>
 * @author Michael Angstadt
 * @rfc 5545 p.97-8
 */
public class DateStart extends DateOrDateTimeProperty {
	/**
	 * Creates a start date property.
	 * @param startDate the start date
	 */
	public DateStart(Date startDate) {
		this(startDate, true);
	}

	/**
	 * Creates a start date property.
	 * @param startDate the start date
	 * @param hasTime true to include the time component of the date, false not
	 * to
	 */
	public DateStart(Date startDate, boolean hasTime) {
		super(startDate, hasTime);
	}

	/**
	 * Creates a start date property.
	 * @param components the raw components of the date-time value
	 */
	public DateStart(DateTimeComponents components) {
		super(components);
	}
}