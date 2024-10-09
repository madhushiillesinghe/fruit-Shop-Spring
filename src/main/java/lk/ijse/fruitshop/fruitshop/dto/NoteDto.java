package lk.ijse.fruitshop.fruitshop.dto;

import lk.ijse.fruitshop.fruitshop.customObj.NoteResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDto implements  SuperDTO, NoteResponse {
    private String noteId;
    private String noteTitle;
    private String noteDecs;
    private String priorityLevel;
    private String createDate;
    private String userId;
}
