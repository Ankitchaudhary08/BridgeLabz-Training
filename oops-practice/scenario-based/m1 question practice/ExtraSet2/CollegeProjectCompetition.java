import java.util.*;

public class CollegeProjectCompetition {

    static class ProjectTeam {
        String teamId, section, domain, projectName;
        int projectScore;

        ProjectTeam(String teamId, String section, String domain, String projectName, int projectScore) {
            this.teamId = teamId;
            this.section = section;
            this.domain = domain;
            this.projectName = projectName;
            this.projectScore = projectScore;
        }

        @Override
        public String toString() {
            return teamId + " " + section + " " + domain + " " + projectName + " " + projectScore;
        }
    }

    static List<ProjectTeam> teams = new ArrayList<>();
    static Set<String> teamIds = new HashSet<>();

    static void registerTeam(String teamId, String section, String domain, String projectName, int projectScore) {
        if (!teamIds.contains(teamId)) {
            teams.add(new ProjectTeam(teamId, section, domain, projectName, projectScore));
            teamIds.add(teamId);
        }
    }

    static String reviseScore(String teamId, int newScore) {
        for (ProjectTeam t : teams) {
            if (t.teamId.equals(teamId)) {
                t.projectScore = newScore;
                return "REVISED " + teamId + " " + newScore;
            }
        }
        return "team is not available";
    }

    static List<ProjectTeam> filterByDomain(String domain) {
        List<ProjectTeam> result = new ArrayList<>();
        for (ProjectTeam t : teams) {
            if (t.domain.equals(domain)) result.add(t);
        }
        return result;
    }

    static List<ProjectTeam> qualifyTeams(int cutoff) {
        List<ProjectTeam> result = new ArrayList<>();
        for (ProjectTeam t : teams) {
            if (t.projectScore >= cutoff) result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String cmd = parts[0];

            if (cmd.equals("REGISTER")) {
                String teamId = parts[1];
                String section = parts[2];
                String domain = parts[3];
                String projectName = parts[4];
                int score = Integer.parseInt(parts[5]);
                registerTeam(teamId, section, domain, projectName, score);
            } else if (cmd.equals("REVISE")) {
                String teamId = parts[1];
                int newScore = Integer.parseInt(parts[2]);
                System.out.println(reviseScore(teamId, newScore));
            } else if (cmd.equals("FILTERDOMAIN")) {
                String domain = parts[1];
                List<ProjectTeam> result = filterByDomain(domain);
                if (result.isEmpty()) {
                    System.out.println("Team is not available for the domain: " + domain);
                } else {
                    for (ProjectTeam t : result) System.out.println(t);
                }
            } else if (cmd.equals("QUALIFY")) {
                int cutoff = Integer.parseInt(parts[1]);
                List<ProjectTeam> result = qualifyTeams(cutoff);
                if (result.isEmpty()) {
                    System.out.println("No team qualified");
                } else {
                    for (ProjectTeam t : result) System.out.println(t);
                }
            }
        }
        sc.close();
    }
}
