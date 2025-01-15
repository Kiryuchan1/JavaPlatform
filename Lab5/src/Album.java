import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Album {
    private List<MusicTrack> tracks;

    public Album() {
        this.tracks = new ArrayList<>();
    }

    public void addTrack(MusicTrack track) {
        if (track == null) {
            throw new NullPointerException("Track cannot be null");
        }
        this.tracks.add(track);
    }

    public List<MusicTrack> getTracks() {
        return tracks;
    }

    public int getTotalDuration() {
        return tracks.stream().mapToInt(MusicTrack::getDurationSeconds).sum();
    }

    public void sortByStyle() {
        if (tracks.isEmpty()){
            throw new IllegalStateException("Cannot sort an empty album");
        }
        tracks.sort((track1, track2) -> {
            if (track1 instanceof ClassicalTrack && !(track2 instanceof ClassicalTrack)) return -1;
            if (track2 instanceof ClassicalTrack && !(track1 instanceof ClassicalTrack)) return 1;
            if (track1 instanceof RockTrack && !(track2 instanceof RockTrack)) return -1;
            if (track2 instanceof RockTrack && !(track1 instanceof RockTrack)) return 1;
            if (track1 instanceof PopTrack && !(track2 instanceof PopTrack)) return -1;
            if (track2 instanceof PopTrack && !(track1 instanceof PopTrack)) return 1;
            return 0;
        });
    }

    public String findTracksByDuration(int minDuration, int maxDuration) {
        if (minDuration > maxDuration) {
            throw new IllegalArgumentException("Min duration cannot be bigger then max duration");
        }
        List<MusicTrack> filteredTracks = tracks.stream()
                .filter(track -> track.getDurationSeconds() >= minDuration && track.getDurationSeconds() <= maxDuration)
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder("[\n");
        for (MusicTrack track : filteredTracks) {
            sb.append(track.toString()).append(",\n\n");
        }
        if (!filteredTracks.isEmpty()){
            sb.delete(sb.length() - 3, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Album{\n");
        sb.append("tracks=[\n");
        for (MusicTrack track : tracks) {
            sb.append(track.toString()).append(",\n\n");
        }
        if (!tracks.isEmpty()){
            sb.delete(sb.length() - 3, sb.length());
        }
        sb.append("]\n");
        sb.append("}");
        return sb.toString();
    }
}