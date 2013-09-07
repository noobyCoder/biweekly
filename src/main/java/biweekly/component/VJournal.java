package biweekly.component;

import java.util.Date;
import java.util.List;

import biweekly.property.Attachment;
import biweekly.property.Attendee;
import biweekly.property.Categories;
import biweekly.property.Classification;
import biweekly.property.Comment;
import biweekly.property.Contact;
import biweekly.property.Created;
import biweekly.property.DateStart;
import biweekly.property.DateTimeStamp;
import biweekly.property.Description;
import biweekly.property.ExceptionDates;
import biweekly.property.ExceptionRule;
import biweekly.property.LastModified;
import biweekly.property.Method;
import biweekly.property.Organizer;
import biweekly.property.RecurrenceDates;
import biweekly.property.RecurrenceId;
import biweekly.property.RecurrenceRule;
import biweekly.property.RelatedTo;
import biweekly.property.RequestStatus;
import biweekly.property.Sequence;
import biweekly.property.Status;
import biweekly.property.Summary;
import biweekly.property.Uid;
import biweekly.property.Url;
import biweekly.util.Recurrence;

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
 * Defines descriptive text associated with the calendar data.
 * </p>
 * <p>
 * <b>Examples:</b>
 * 
 * <pre class="brush:java">
 * VJournal journal = new VJournal();
 * journal.setSummary("Team Meeting");
 * journal.setDescription("The following items were discussed: ...");
 * byte[] slides = ...
 * journal.addAttachment(new Attachment("application/vnd.ms-powerpoint", slides));
 * </pre>
 * 
 * </p>
 * @author Michael Angstadt
 * @rfc 5545 p.57-9
 */
public class VJournal extends ICalComponent {
	/**
	 * <p>
	 * Creates a new journal entry.
	 * </p>
	 * <p>
	 * The following properties are auto-generated on object creation. These
	 * properties <b>must</b> be present in order for the journal entry to be
	 * valid:
	 * <ul>
	 * <li>{@link Uid} - Set to a UUID.</li>
	 * <li>{@link DateTimeStamp} - Set to the current date-time.</li>
	 * </ul>
	 * </p>
	 */
	public VJournal() {
		setUid(Uid.random());
		setDateTimeStamp(new Date());
	}

	/**
	 * Gets the unique identifier for this journal entry. This component object
	 * comes populated with a UID on creation. This is a <b>required</b>
	 * property.
	 * @return the UID or null if not set
	 * @rfc 5545 p.117-8
	 */
	public Uid getUid() {
		return getProperty(Uid.class);
	}

	/**
	 * Sets the unique identifier for this journal entry. This component object
	 * comes populated with a UID on creation. This is a <b>required</b>
	 * property.
	 * @param uid the UID or null to remove
	 * @rfc 5545 p.117-8
	 */
	public void setUid(Uid uid) {
		setProperty(Uid.class, uid);
	}

	/**
	 * Sets the unique identifier for this journal entry. This component object
	 * comes populated with a UID on creation. This is a <b>required</b>
	 * property.
	 * @param uid the UID or null to remove
	 * @return the property that was created
	 * @rfc 5545 p.117-8
	 */
	public Uid setUid(String uid) {
		Uid prop = (uid == null) ? null : new Uid(uid);
		setUid(prop);
		return prop;
	}

	/**
	 * Gets either (a) the creation date of the iCalendar object (if the
	 * {@link Method} property is defined) or (b) the date that the journal
	 * entry was last modified (the {@link LastModified} property also holds
	 * this information). This journal entry object comes populated with a
	 * {@link DateTimeStamp} property that is set to the current time. This is a
	 * <b>required</b> property.
	 * @return the date time stamp or null if not set
	 * @rfc 5545 p.137-8
	 */
	public DateTimeStamp getDateTimeStamp() {
		return getProperty(DateTimeStamp.class);
	}

	/**
	 * Sets either (a) the creation date of the iCalendar object (if the
	 * {@link Method} property is defined) or (b) the date that the journal
	 * entry was last modified (the {@link LastModified} property also holds
	 * this information). This journal entry object comes populated with a
	 * {@link DateTimeStamp} property that is set to the current time. This is a
	 * <b>required</b> property.
	 * @param dateTimeStamp the date time stamp or null to remove
	 * @rfc 5545 p.137-8
	 */
	public void setDateTimeStamp(DateTimeStamp dateTimeStamp) {
		setProperty(DateTimeStamp.class, dateTimeStamp);
	}

	/**
	 * Sets either (a) the creation date of the iCalendar object (if the
	 * {@link Method} property is defined) or (b) the date that the journal
	 * entry was last modified (the {@link LastModified} property also holds
	 * this information). This journal entry object comes populated with a
	 * {@link DateTimeStamp} property that is set to the current time. This is a
	 * <b>required</b> property.
	 * @param dateTimeStamp the date time stamp or null to remove
	 * @return the property that was created
	 * @rfc 5545 p.137-8
	 */
	public DateTimeStamp setDateTimeStamp(Date dateTimeStamp) {
		DateTimeStamp prop = (dateTimeStamp == null) ? null : new DateTimeStamp(dateTimeStamp);
		setDateTimeStamp(prop);
		return prop;
	}

	/**
	 * Gets the level of sensitivity of the journal entry. If not specified, the
	 * data within the journal entry should be considered "public".
	 * @return the classification level or null if not set
	 * @rfc 5545 p.82-3
	 */
	public Classification getClassification() {
		return getProperty(Classification.class);
	}

	/**
	 * Sets the level of sensitivity of the journal entry. If not specified, the
	 * data within the journal entry should be considered "public".
	 * @param classification the classification level or null to remove
	 * @rfc 5545 p.82-3
	 */
	public void setClassification(Classification classification) {
		setProperty(Classification.class, classification);
	}

	/**
	 * Sets the level of sensitivity of the journal entry. If not specified, the
	 * data within the journal entry should be considered "public".
	 * @param classification the classification level (e.g. "CONFIDENTIAL") or
	 * null to remove
	 * @return the property that was created
	 * @rfc 5545 p.82-3
	 */
	public Classification setClassification(String classification) {
		Classification prop = (classification == null) ? null : new Classification(classification);
		setClassification(prop);
		return prop;
	}

	/**
	 * Gets the date-time that the journal entry was initially created.
	 * @return the creation date-time or null if not set
	 * @rfc 5545 p.136
	 */
	public Created getCreated() {
		return getProperty(Created.class);
	}

	/**
	 * Sets the date-time that the journal entry was initially created.
	 * @param created the creation date-time or null to remove
	 * @rfc 5545 p.136
	 */
	public void setCreated(Created created) {
		setProperty(Created.class, created);
	}

	/**
	 * Sets the date-time that the journal entry was initially created.
	 * @param created the creation date-time or null to remove
	 * @return the property that was created
	 * @rfc 5545 p.136
	 */
	public Created setCreated(Date created) {
		Created prop = (created == null) ? null : new Created(created);
		setCreated(prop);
		return prop;
	}

	/**
	 * Gets the date that the journal entry starts.
	 * @return the start date or null if not set
	 * @rfc 5545 p.97-8
	 */
	public DateStart getDateStart() {
		return getProperty(DateStart.class);
	}

	/**
	 * Sets the date that the journal entry starts.
	 * @param dateStart the start date or null to remove
	 * @rfc 5545 p.97-8
	 */
	public void setDateStart(DateStart dateStart) {
		setProperty(DateStart.class, dateStart);
	}

	/**
	 * Sets the date that the journal entry starts.
	 * @param dateStart the start date or null to remove
	 * @return the property that was created
	 * @rfc 5545 p.97-8
	 */
	public DateStart setDateStart(Date dateStart) {
		DateStart prop = (dateStart == null) ? null : new DateStart(dateStart);
		setDateStart(prop);
		return prop;
	}

	/**
	 * Gets the date-time that the journal entry was last changed.
	 * @return the last modified date or null if not set
	 * @rfc 5545 p.138
	 */
	public LastModified getLastModified() {
		return getProperty(LastModified.class);
	}

	/**
	 * Sets the date-time that the journal entry was last changed.
	 * @param lastModified the last modified date or null to remove
	 * @rfc 5545 p.138
	 */
	public void setLastModified(LastModified lastModified) {
		setProperty(LastModified.class, lastModified);
	}

	/**
	 * Sets the date-time that the journal entry was last changed.
	 * @param lastModified the last modified date or null to remove
	 * @return the property that was created
	 * @rfc 5545 p.138
	 */
	public LastModified setLastModified(Date lastModified) {
		LastModified prop = (lastModified == null) ? null : new LastModified(lastModified);
		setLastModified(prop);
		return prop;
	}

	/**
	 * Gets the organizer of the journal entry.
	 * @return the organizer or null if not set
	 * @rfc 5545 p.111-2
	 */
	public Organizer getOrganizer() {
		return getProperty(Organizer.class);
	}

	/**
	 * Sets the organizer of the journal entry.
	 * @param organizer the organizer or null to remove
	 * @rfc 5545 p.111-2
	 */
	public void setOrganizer(Organizer organizer) {
		setProperty(Organizer.class, organizer);
	}

	/**
	 * Sets the organizer of the journal entry.
	 * @param email the organizer's email address (e.g. "johndoe@example.com")
	 * or null to remove
	 * @return the property that was created
	 * @rfc 5545 p.111-2
	 */
	public Organizer setOrganizer(String email) {
		Organizer prop = (email == null) ? null : Organizer.email(email);
		setOrganizer(prop);
		return prop;
	}

	/**
	 * Gets the original value of the {@link DateStart} property if the event is
	 * recurring and has been modified. Used in conjunction with the {@link Uid}
	 * and {@link Sequence} properties to uniquely identify a recurrence
	 * instance.
	 * @return the recurrence ID or null if not set
	 * @rfc 5545 p.112-4
	 */
	public RecurrenceId getRecurrenceId() {
		return getProperty(RecurrenceId.class);
	}

	/**
	 * Sets the original value of the {@link DateStart} property if the event is
	 * recurring and has been modified. Used in conjunction with the {@link Uid}
	 * and {@link Sequence} properties to uniquely identify a recurrence
	 * instance.
	 * @param recurrenceId the recurrence ID or null to remove
	 * @rfc 5545 p.112-4
	 */
	public void setRecurrenceId(RecurrenceId recurrenceId) {
		setProperty(RecurrenceId.class, recurrenceId);
	}

	/**
	 * Sets the original value of the {@link DateStart} property if the journal
	 * entry is recurring and has been modified. Used in conjunction with the
	 * {@link Uid} and {@link Sequence} properties to uniquely identify a
	 * recurrence instance.
	 * @param originalStartDate the original start date or null to remove
	 * @rfc 5545 p.112-4
	 */
	public RecurrenceId setRecurrenceId(Date originalStartDate) {
		RecurrenceId prop = (originalStartDate == null) ? null : new RecurrenceId(originalStartDate);
		setRecurrenceId(prop);
		return prop;
	}

	/**
	 * Gets the revision number of the journal entry. The organizer can
	 * increment this number every time he or she makes a significant change.
	 * @return the sequence number
	 * @rfc 5545 p.138-9
	 */
	public Sequence getSequence() {
		return getProperty(Sequence.class);
	}

	/**
	 * Sets the revision number of the journal entry. The organizer can
	 * increment this number every time he or she makes a significant change.
	 * @param sequence the sequence number
	 * @rfc 5545 p.138-9
	 */
	public void setSequence(Sequence sequence) {
		setProperty(Sequence.class, sequence);
	}

	/**
	 * Sets the revision number of the journal entry. The organizer can
	 * increment this number every time he or she makes a significant change.
	 * @param sequence the sequence number
	 * @return the property that was created
	 * @rfc 5545 p.138-9
	 */
	public Sequence setSequence(Integer sequence) {
		Sequence prop = (sequence == null) ? null : new Sequence(sequence);
		setSequence(prop);
		return prop;
	}

	/**
	 * Increments the revision number of the journal entry. The organizer can
	 * increment this number every time he or she makes a significant change.
	 * @rfc 5545 p.138-9
	 */
	public void incrementSequence() {
		Sequence sequence = getSequence();
		if (sequence == null) {
			setSequence(1);
		} else {
			sequence.increment();
		}
	}

	/**
	 * Gets the status of the journal entry.
	 * @return the status or null if not set
	 * @rfc 5545 p.92-3
	 */
	public Status getStatus() {
		return getProperty(Status.class);
	}

	/**
	 * Sets the status of the journal entry.
	 * <p>
	 * Valid journal status codes are:
	 * <ul>
	 * <li>DRAFT</li>
	 * <li>FINAL</li>
	 * <li>CANCELLED</li>
	 * </ul>
	 * </p>
	 * @param status the status or null to remove
	 * @rfc 5545 p.92-3
	 */
	public void setStatus(Status status) {
		setProperty(Status.class, status);
	}

	/**
	 * Gets the summary of the journal entry.
	 * @return the summary or null if not set
	 * @rfc 5545 p.93-4
	 */
	public Summary getSummary() {
		return getProperty(Summary.class);
	}

	/**
	 * Sets the summary of the journal entry.
	 * @param summary the summary or null to remove
	 * @rfc 5545 p.93-4
	 */
	public void setSummary(Summary summary) {
		setProperty(Summary.class, summary);
	}

	/**
	 * Sets the summary of the journal entry.
	 * @param summary the summary or null to remove
	 * @return the property that was created
	 * @rfc 5545 p.93-4
	 */
	public Summary setSummary(String summary) {
		Summary prop = (summary == null) ? null : new Summary(summary);
		setSummary(prop);
		return prop;
	}

	/**
	 * Gets a URL to a resource that contains additional information about the
	 * journal entry.
	 * @return the URL or null if not set
	 * @rfc 5545 p.116-7
	 */
	public Url getUrl() {
		return getProperty(Url.class);
	}

	/**
	 * Sets a URL to a resource that contains additional information about the
	 * journal entry.
	 * @param url the URL or null to remove
	 * @rfc 5545 p.116-7
	 */
	public void setUrl(Url url) {
		setProperty(Url.class, url);
	}

	/**
	 * Sets a URL to a resource that contains additional information about the
	 * journal entry.
	 * @param url the URL (e.g. "http://example.com/resource.ics") or null to
	 * remove
	 * @return the property that was created
	 * @rfc 5545 p.116-7
	 */
	public Url setUrl(String url) {
		Url prop = (url == null) ? null : new Url(url);
		setUrl(prop);
		return prop;
	}

	/**
	 * Gets how often the journal entry repeats.
	 * @return the recurrence rule or null if not set
	 * @rfc 5545 p.122-32
	 */
	public RecurrenceRule getRecurrenceRule() {
		return getProperty(RecurrenceRule.class);
	}

	/**
	 * Sets how often the journal entry repeats.
	 * @param recur the recurrence rule or null to remove
	 * @return the property that was created
	 * @rfc 5545 p.122-32
	 */
	public RecurrenceRule setRecurrenceRule(Recurrence recur) {
		RecurrenceRule prop = (recur == null) ? null : new RecurrenceRule(recur);
		setRecurrenceRule(prop);
		return prop;
	}

	/**
	 * Sets how often the journal entry repeats.
	 * @param recurrenceRule the recurrence rule or null to remove
	 * @rfc 5545 p.122-32
	 */
	public void setRecurrenceRule(RecurrenceRule recurrenceRule) {
		setProperty(RecurrenceRule.class, recurrenceRule);
	}

	/**
	 * Gets any attachments that are associated with the journal entry.
	 * @return the attachments
	 * @rfc 5545 p.80-1
	 */
	public List<Attachment> getAttachments() {
		return getProperties(Attachment.class);
	}

	/**
	 * Adds an attachment to the journal entry.
	 * @param attachment the attachment to add
	 * @rfc 5545 p.80-1
	 */
	public void addAttachment(Attachment attachment) {
		addProperty(attachment);
	}

	/**
	 * Gets the people who are involved in the journal entry.
	 * @return the attendees
	 * @rfc 5545 p.107-9
	 */
	public List<Attendee> getAttendees() {
		return getProperties(Attendee.class);
	}

	/**
	 * Adds a person who is involved in the journal entry.
	 * @param attendee the attendee
	 * @rfc 5545 p.107-9
	 */
	public void addAttendee(Attendee attendee) {
		addProperty(attendee);
	}

	/**
	 * Adds a person who is involved in the journal entry.
	 * @param email the attendee's email address
	 * @return the property that was created
	 * @rfc 5545 p.107-9
	 */
	public Attendee addAttendee(String email) {
		Attendee prop = Attendee.email(email);
		addAttendee(prop);
		return prop;
	}

	/**
	 * Gets a list of "tags" or "keywords" that describe the journal entry.
	 * @return the categories
	 * @rfc 5545 p.81-2
	 */
	public List<Categories> getCategories() {
		return getProperties(Categories.class);
	}

	/**
	 * Adds a list of "tags" or "keywords" that describe the journal entry. Note
	 * that a single property can hold multiple keywords.
	 * @param categories the categories to add
	 * @rfc 5545 p.81-2
	 */
	public void addCategories(Categories categories) {
		addProperty(categories);
	}

	/**
	 * Adds a list of "tags" or "keywords" that describe the journal entry.
	 * @param categories the categories to add
	 * @return the property that was created
	 * @rfc 5545 p.81-2
	 */
	public Categories addCategories(String... categories) {
		Categories prop = new Categories(categories);
		addCategories(prop);
		return prop;
	}

	/**
	 * Adds a list of "tags" or "keywords" that describe the journal entry.
	 * @param categories the categories to add
	 * @return the property that was created
	 * @rfc 5545 p.81-2
	 */
	public Categories addCategories(List<String> categories) {
		Categories prop = new Categories(categories);
		addCategories(prop);
		return prop;
	}

	/**
	 * Gets the comments attached to the journal entry.
	 * @return the comments
	 * @rfc 5545 p.83-4
	 */
	public List<Comment> getComments() {
		return getProperties(Comment.class);
	}

	/**
	 * Adds a comment to the journal entry.
	 * @param comment the comment to add
	 * @rfc 5545 p.83-4
	 */
	public void addComment(Comment comment) {
		addProperty(comment);
	}

	/**
	 * Adds a comment to the journal entry.
	 * @param comment the comment to add
	 * @return the property that was created
	 * @rfc 5545 p.83-4
	 */
	public Comment addComment(String comment) {
		Comment prop = new Comment(comment);
		addComment(prop);
		return prop;
	}

	/**
	 * Gets the contacts associated with the journal entry.
	 * @return the contacts
	 * @rfc 5545 p.109-11
	 */
	public List<Contact> getContacts() {
		return getProperties(Contact.class);
	}

	/**
	 * Adds a contact to the journal entry.
	 * @param contact the contact
	 * @rfc 5545 p.109-11
	 */
	public void addContact(Contact contact) {
		addProperty(contact);
	}

	/**
	 * Adds a contact to the journal entry.
	 * @param contact the contact (e.g. "ACME Co - (123) 555-1234")
	 * @return the property that was created
	 * @rfc 5545 p.109-11
	 */
	public Contact addContact(String contact) {
		Contact prop = new Contact(contact);
		addContact(prop);
		return prop;
	}

	/**
	 * Gets the detailed descriptions to the journal entry. The descriptions
	 * should be a more detailed version of the one provided by the
	 * {@link Summary} property.
	 * @return the descriptions
	 * @rfc 5545 p.84-5
	 */
	public List<Description> getDescriptions() {
		return getProperties(Description.class);
	}

	/**
	 * Adds a detailed description to the journal entry. The description should
	 * be a more detailed version of the one provided by the {@link Summary}
	 * property.
	 * @param description the description
	 * @rfc 5545 p.84-5
	 */
	public void addDescription(Description description) {
		addProperty(description);
	}

	/**
	 * Adds a detailed description to the journal entry. The description should
	 * be a more detailed version of the one provided by the {@link Summary}
	 * property.
	 * @param description the description
	 * @return the property that was created
	 * @rfc 5545 p.84-5
	 */
	public Description addDescription(String description) {
		Description prop = new Description(description);
		addDescription(prop);
		return prop;
	}

	/**
	 * Gets the list of exceptions to the recurrence rule defined in the journal
	 * entry (if one is defined).
	 * @return the list of exceptions
	 * @rfc 5545 p.118-20
	 */
	public List<ExceptionDates> getExceptionDates() {
		return getProperties(ExceptionDates.class);
	}

	/**
	 * Adds a list of exceptions to the recurrence rule defined in the journal
	 * entry (if one is defined). Note that this property can contain multiple
	 * dates.
	 * @param exceptionDates the list of exceptions
	 * @rfc 5545 p.118-20
	 */
	public void addExceptionDates(ExceptionDates exceptionDates) {
		addProperty(exceptionDates);
	}

	/**
	 * Gets the components that the journal entry is related to.
	 * @return the relationships
	 * @rfc 5545 p.115-6
	 */
	public List<RelatedTo> getRelatedTo() {
		return getProperties(RelatedTo.class);
	}

	/**
	 * Adds a component that the journal entry is related to.
	 * @param relatedTo the relationship
	 * @rfc 5545 p.115-6
	 */
	public void addRelatedTo(RelatedTo relatedTo) {
		//TODO create a method that accepts a component and make the RelatedTo property invisible to the user
		//@formatter:off
		/*
		 * addRelation(RelationshipType relType, ICalComponent component){
		 *   RelatedTo prop = new RelatedTo(component.getUid().getValue());
		 *   prop.setRelationshipType(relType);
		 *   addProperty(prop);
		 * }
		 */
		//@formatter:on
		addProperty(relatedTo);
	}

	/**
	 * Adds a component that the journal entry is related to.
	 * @param uid the UID of the other component
	 * @return the property that was created
	 * @rfc 5545 p.115-6
	 */
	public RelatedTo addRelatedTo(String uid) {
		RelatedTo prop = new RelatedTo(uid);
		addRelatedTo(prop);
		return prop;
	}

	/**
	 * Gets the list of dates/periods that help define the recurrence rule of
	 * this journal entry (if one is defined).
	 * @return the recurrence dates
	 * @rfc 5545 p.120-2
	 */
	public List<RecurrenceDates> getRecurrenceDates() {
		return getProperties(RecurrenceDates.class);
	}

	/**
	 * Adds a list of dates/periods that help define the recurrence rule of this
	 * journal entry (if one is defined).
	 * @param recurrenceDates the recurrence dates
	 * @rfc 5545 p.120-2
	 */
	public void addRecurrenceDates(RecurrenceDates recurrenceDates) {
		addProperty(recurrenceDates);
	}

	/**
	 * Gets the response to a scheduling request.
	 * @return the response
	 * @rfc 5545 p.141-3
	 */
	public RequestStatus getRequestStatus() {
		return getProperty(RequestStatus.class);
	}

	/**
	 * Sets the response to a scheduling request.
	 * @param requestStatus the response
	 * @rfc 5545 p.141-3
	 */
	public void setRequestStatus(RequestStatus requestStatus) {
		setProperty(RequestStatus.class, requestStatus);
	}

	/**
	 * <p>
	 * Gets the exceptions for the {@link RecurrenceRule} property.
	 * </p>
	 * <p>
	 * Note that this property has been removed from the latest version of the
	 * iCal specification. Its use should be avoided.
	 * </p>
	 * @return the exception rules
	 * @rfc 2445 p.114-15
	 */
	public List<ExceptionRule> getExceptionRules() {
		return getProperties(ExceptionRule.class);
	}

	/**
	 * <p>
	 * Adds an exception for the {@link RecurrenceRule} property.
	 * </p>
	 * <p>
	 * Note that this property has been removed from the latest version of the
	 * iCal specification. Its use should be avoided.
	 * </p>
	 * @param recur the exception rule to add
	 * @return the property that was created
	 * @rfc 2445 p.114-15
	 */
	public ExceptionRule addExceptionRule(Recurrence recur) {
		ExceptionRule prop = (recur == null) ? null : new ExceptionRule(recur);
		addExceptionRule(prop);
		return prop;
	}

	/**
	 * <p>
	 * Adds an exception for the {@link RecurrenceRule} property.
	 * </p>
	 * <p>
	 * Note that this property has been removed from the latest version of the
	 * iCal specification. Its use should be avoided.
	 * </p>
	 * @param exceptionRule the exception rule to add
	 * @rfc 2445 p.114-15
	 */
	public void addExceptionRule(ExceptionRule exceptionRule) {
		addProperty(exceptionRule);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void validate(List<ICalComponent> components, List<String> warnings) {
		checkRequiredCardinality(warnings, Uid.class, DateTimeStamp.class);
		checkOptionalCardinality(warnings, Classification.class, Created.class, DateStart.class, LastModified.class, Organizer.class, RecurrenceId.class, Sequence.class, Status.class, Summary.class, Url.class);

		Status status = getStatus();
		if (status != null && (status.isTentative() || status.isConfirmed() || status.isNeedsAction() || status.isCompleted() || status.isInProgress())) {
			warnings.add("Invalid status value (\"" + status.getValue() + "\").  Valid status values are \"draft\", \"final\", and \"cancelled\".");
		}

		RecurrenceId recurrenceId = getRecurrenceId();
		DateStart dateStart = getDateStart();
		if (recurrenceId != null && dateStart != null && dateStart.hasTime() != recurrenceId.hasTime()) {
			warnings.add("Both " + DateStart.class.getSimpleName() + " and " + RecurrenceId.class.getSimpleName() + " must have the same data type (they must either both be dates or both be datetimes).");
		}

		//RFC 5545 p. 167
		RecurrenceRule rrule = getRecurrenceRule();
		if (dateStart != null && rrule != null) {
			Date start = dateStart.getValue();
			Recurrence recur = rrule.getValue();
			if (start != null && recur != null) {
				if (!dateStart.hasTime() && (!recur.getByHour().isEmpty() || !recur.getByMinute().isEmpty() || !recur.getBySecond().isEmpty())) {
					warnings.add("The BYHOUR, BYMINUTE, and BYSECOND rule parts cannot be specified in the " + RecurrenceRule.class.getSimpleName() + " property when the " + DateStart.class.getSimpleName() + " property contains a date value (as opposed to a date-time value).");
				}
			}
		}

		//RFC 5545 p. 167
		if (getProperties(RecurrenceRule.class).size() > 1) {
			warnings.add("There should be only one instance of the " + RecurrenceRule.class.getSimpleName() + " property.");
		}
	}
}
