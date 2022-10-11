package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class CreateJiraResponse {
    @JsonProperty("expand")
    private String expand;
    @JsonProperty("id")
    private String id;
    @JsonProperty("self")
    private String self;
    @JsonProperty("key")
    private String key;
    @JsonProperty("fields")
    private Fields fields;
    @Data
    public static class Fields {

        @JsonProperty("statuscategorychangedate")
        private String statuscategorychangedate;
        @JsonProperty("issuetype")
        private Issuetype issuetype;
        @Data
        public static class Issuetype {

            @JsonProperty("self")
            private String self;
            @JsonProperty("id")
            private String id;
            @JsonProperty("description")
            private String description;
            @JsonProperty("iconUrl")
            private String iconUrl;
            @JsonProperty("name")
            private String name;
            @JsonProperty("subtask")
            private Boolean subtask;
            @JsonProperty("avatarId")
            private Integer avatarId;
            @JsonProperty("entityId")
            private String entityId;
            @JsonProperty("hierarchyLevel")
            private Integer hierarchyLevel;

        }
        @JsonProperty("timespent")
        private Object timespent;
        @JsonProperty("project")
        private Project project;
        @Data
        public static class Project {

            @JsonProperty("self")
            private String self;
            @JsonProperty("id")
            private String id;
            @JsonProperty("key")
            private String key;
            @JsonProperty("name")
            private String name;
            @JsonProperty("projectTypeKey")
            private String projectTypeKey;
            @JsonProperty("simplified")
            private Boolean simplified;
            @JsonProperty("avatarUrls")
            private AvatarUrls avatarUrls;
            @Data
            public static class AvatarUrls {

                @JsonProperty("48x48")
                private String _48x48;
                @JsonProperty("24x24")
                private String _24x24;
                @JsonProperty("16x16")
                private String _16x16;
                @JsonProperty("32x32")
                private String _32x32;

            }

        }
        @JsonProperty("fixVersions")
        private List<Object> fixVersions = null;
        @JsonProperty("aggregatetimespent")
        private Object aggregatetimespent;
        @JsonProperty("resolution")
        private Object resolution;
        @JsonProperty("customfield_10027")
        private Object customfield10027;
        @JsonProperty("customfield_10028")
        private Object customfield10028;
        @JsonProperty("customfield_10029")
        private Object customfield10029;
        @JsonProperty("resolutiondate")
        private Object resolutiondate;
        @JsonProperty("workratio")
        private Integer workratio;
        @JsonProperty("issuerestriction")
        private Issuerestriction issuerestriction;
        @Data
        public static class Issuerestriction {

            @JsonProperty("issuerestrictions")
            private Issuerestrictions issuerestrictions;
            @Data
            public static class Issuerestrictions {


            }
            @JsonProperty("shouldDisplay")
            private Boolean shouldDisplay;

        }
        @JsonProperty("lastViewed")
        private Object lastViewed;
        @JsonProperty("watches")
        private Watches watches;
        @Data
        public static class Watches {

            @JsonProperty("self")
            private String self;
            @JsonProperty("watchCount")
            private Integer watchCount;
            @JsonProperty("isWatching")
            private Boolean isWatching;

        }
        @JsonProperty("created")
        private String created;
        @JsonProperty("customfield_10020")
        private Object customfield10020;
        @JsonProperty("customfield_10021")
        private Object customfield10021;
        @JsonProperty("customfield_10022")
        private Object customfield10022;
        @JsonProperty("priority")
        private Priority priority;
        @Data
        public static class Priority {

            @JsonProperty("self")
            private String self;
            @JsonProperty("iconUrl")
            private String iconUrl;
            @JsonProperty("name")
            private String name;
            @JsonProperty("id")
            private String id;

        }

        @JsonProperty("customfield_10023")
        private Object customfield10023;
        @JsonProperty("customfield_10024")
        private Object customfield10024;
        @JsonProperty("customfield_10025")
        private Object customfield10025;
        @JsonProperty("customfield_10026")
        private Object customfield10026;
        @JsonProperty("labels")
        private List<Object> labels = null;
        @JsonProperty("customfield_10016")
        private Object customfield10016;
        @JsonProperty("customfield_10017")
        private Object customfield10017;
        @JsonProperty("customfield_10018")
        private Customfield10018 customfield10018;
        @Data
        public static class Customfield10018 {

            @JsonProperty("hasEpicLinkFieldDependency")
            private Boolean hasEpicLinkFieldDependency;
            @JsonProperty("showField")
            private Boolean showField;
            @JsonProperty("nonEditableReason")
            private NonEditableReason nonEditableReason;
            @Data
            public static class NonEditableReason {

                @JsonProperty("reason")
                private String reason;
                @JsonProperty("message")
                private String message;

            }

        }
        @JsonProperty("customfield_10019")
        private String customfield10019;
        @JsonProperty("timeestimate")
        private Object timeestimate;
        @JsonProperty("aggregatetimeoriginalestimate")
        private Object aggregatetimeoriginalestimate;
        @JsonProperty("versions")
        private List<Object> versions = null;
        @JsonProperty("issuelinks")
        private List<Object> issuelinks = null;
        @JsonProperty("assignee")
        private Object assignee;
        @JsonProperty("updated")
        private String updated;
        @JsonProperty("status")
        private Status status;
        @Data
        public static class Status {

            @JsonProperty("self")
            private String self;
            @JsonProperty("description")
            private String description;
            @JsonProperty("iconUrl")
            private String iconUrl;
            @JsonProperty("name")
            private String name;
            @JsonProperty("id")
            private String id;
            @JsonProperty("statusCategory")
            private StatusCategory statusCategory;
            @Data
            public static class StatusCategory {

                @JsonProperty("self")
                private String self;
                @JsonProperty("id")
                private Integer id;
                @JsonProperty("key")
                private String key;
                @JsonProperty("colorName")
                private String colorName;
                @JsonProperty("name")
                private String name;

            }

        }
        @JsonProperty("components")
        private List<Object> components = null;
        @JsonProperty("timeoriginalestimate")
        private Object timeoriginalestimate;
        @JsonProperty("description")
        private Object description;
        @JsonProperty("customfield_10010")
        private Object customfield10010;
        @JsonProperty("customfield_10014")
        private Object customfield10014;
        @JsonProperty("customfield_10015")
        private Object customfield10015;
        @JsonProperty("timetracking")
        private Timetracking timetracking;
        @Data
        public static class Timetracking {


        }
        @JsonProperty("customfield_10005")
        private Object customfield10005;
        @JsonProperty("customfield_10006")
        private Object customfield10006;
        @JsonProperty("customfield_10007")
        private Object customfield10007;
        @JsonProperty("security")
        private Object security;
        @JsonProperty("customfield_10008")
        private Object customfield10008;
        @JsonProperty("aggregatetimeestimate")
        private Object aggregatetimeestimate;
        @JsonProperty("customfield_10009")
        private Object customfield10009;
        @JsonProperty("attachment")
        private List<Object> attachment = null;
        @JsonProperty("summary")
        private String summary;
        @JsonProperty("creator")
        private Creator creator;
        @Data
        public static class Creator {

            @JsonProperty("self")
            private String self;
            @JsonProperty("accountId")
            private String accountId;
            @JsonProperty("emailAddress")
            private String emailAddress;
            @JsonProperty("avatarUrls")
            private AvatarUrls__1 avatarUrls;
            @Data
            public static class AvatarUrls__1 {

                @JsonProperty("48x48")
                private String _48x48;
                @JsonProperty("24x24")
                private String _24x24;
                @JsonProperty("16x16")
                private String _16x16;
                @JsonProperty("32x32")
                private String _32x32;

            }
            @JsonProperty("displayName")
            private String displayName;
            @JsonProperty("active")
            private Boolean active;
            @JsonProperty("timeZone")
            private String timeZone;
            @JsonProperty("accountType")
            private String accountType;

        }
        @JsonProperty("subtasks")
        private List<Object> subtasks = null;
        @JsonProperty("reporter")
        private Reporter reporter;
        @Data
        public static class Reporter {

            @JsonProperty("self")
            private String self;
            @JsonProperty("accountId")
            private String accountId;
            @JsonProperty("emailAddress")
            private String emailAddress;
            @JsonProperty("avatarUrls")
            private AvatarUrls__2 avatarUrls;
            @Data
            public static class AvatarUrls__2 {

                @JsonProperty("48x48")
                private String _48x48;
                @JsonProperty("24x24")
                private String _24x24;
                @JsonProperty("16x16")
                private String _16x16;
                @JsonProperty("32x32")
                private String _32x32;

            }
            @JsonProperty("displayName")
            private String displayName;
            @JsonProperty("active")
            private Boolean active;
            @JsonProperty("timeZone")
            private String timeZone;
            @JsonProperty("accountType")
            private String accountType;

        }
        @JsonProperty("aggregateprogress")
        private Aggregateprogress aggregateprogress;
        @Data
        public static class Aggregateprogress {

            @JsonProperty("progress")
            private Integer progress;

            @JsonProperty("total")
            private Integer total;

        }
            @JsonProperty("total")
            private Integer total;

        }
        @JsonProperty("customfield_10001")
        private Object customfield10001;
        @JsonProperty("customfield_10002")
        private Object customfield10002;
        @JsonProperty("customfield_10003")
        private Object customfield10003;
        @JsonProperty("customfield_10004")
        private Object customfield10004;
        @JsonProperty("environment")
        private Object environment;
        @JsonProperty("duedate")
        private Object duedate;
        @JsonProperty("progress")
        private Progress progress;
    @Data
    public static class Progress {

        @JsonProperty("progress")
        private Integer progress;
        @JsonProperty("total")
        private Integer total;

    }
        @JsonProperty("comment")
        private Comment comment;
    @Data
        public static class Comment {

            @JsonProperty("comments")
            private List<Object> comments = null;
            @JsonProperty("self")
            private String self;
            @JsonProperty("maxResults")
            private Integer maxResults;
            @JsonProperty("total")
            private Integer total;
            @JsonProperty("startAt")
            private Integer startAt;

        }
        @JsonProperty("votes")
        private Votes votes;
    @Data
    public static class Votes {

        @JsonProperty("self")
        private String self;
        @JsonProperty("votes")
        private Integer votes;
        @JsonProperty("hasVoted")
        private Boolean hasVoted;

    }
        @JsonProperty("worklog")
        private Worklog worklog;
    @Data
    public static class Worklog {

        @JsonProperty("startAt")
        private Integer startAt;
        @JsonProperty("maxResults")
        private Integer maxResults;
        @JsonProperty("total")
        private Integer total;
        @JsonProperty("worklogs")
        private List<Object> worklogs = null;

    }

    }
