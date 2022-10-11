package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

public class JiraServiceRequestPojo {
    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    private Fields fields;
    public static class Fields {

        @JsonProperty("project")
        private Project project;
        @JsonProperty("summary")
        private String summary;
        @JsonProperty("issuetype")
        private Issuetype issuetype;

        public Project getProject() {
            return project;
        }

        public void setProject(Project project) {
            this.project = project;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public Issuetype getIssuetype() {
            return issuetype;
        }

        public void setIssuetype(Issuetype issuetype) {
            this.issuetype = issuetype;
        }

        public Description getDescription() {
            return description;
        }

        public void setDescription(Description description) {
            this.description = description;
        }

        @JsonProperty("description")
        private Description description;

        public static class Project {
            @JsonProperty("key")
            private String key;
            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }



        }

        public static class Issuetype {
            @JsonProperty("name")
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class Description {
            @JsonProperty("type")
            private String type;
            @JsonProperty("version")
            private Integer version;
            @JsonProperty("content")
            private List<Content> content = null;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Integer getVersion() {
                return version;
            }

            public void setVersion(Integer version) {
                this.version = version;
            }

            public List<Content> getContent() {
                return content;
            }

            public void setContent(List<Content> content) {
                this.content = content;
            }



            public static class Content {
                @JsonProperty("type")
                private String type;
                @JsonProperty("content")
                private List<Content__1> content = null;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public List<Content__1> getContent() {
                    return content;
                }

                public void setContent(List<Content__1> content) {
                    this.content = content;
                }

                public static class Content__1 {
                    @JsonProperty("text")
                    private String text;
                    @JsonProperty("type")
                    private String type;
                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }
                }

            }

        }

    }

}