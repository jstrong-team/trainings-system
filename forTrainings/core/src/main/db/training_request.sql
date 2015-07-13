select training.*, meet.id as meet_id, meet.date, meet.place, meet.duration, employee.name as trainer_name from training
join meet on training.id=meet.training_id
join employee on training.trainer_id=employee.id;