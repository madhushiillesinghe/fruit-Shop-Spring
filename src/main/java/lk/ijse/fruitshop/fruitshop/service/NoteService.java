package lk.ijse.fruitshop.fruitshop.service;



import lk.ijse.fruitshop.fruitshop.customObj.NoteResponse;
import lk.ijse.fruitshop.fruitshop.dto.NoteDto;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDto noteDTO);
    void updateNote(String noteId,NoteDto noteDto);
    void deleteNote(String noteId);
   // NoteDto getNote(String noteId);
    List<NoteDto> getAllNote();
    NoteResponse getSelectNote(String noteId);
}
