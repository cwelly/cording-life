using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class doorenable : MonoBehaviour {
    [SerializeField] public Text door_inform;
    [SerializeField] public Image im;
    public GameObject enablespace;
    public GameObject door;
    public GameObject sound;
    Animator dooropen;
	// Use this for initialization
	void Start () {
        im.enabled = false;
        dooropen = door.GetComponent<Animator>();
        door_inform.enabled = false;
	}

    private void OnTriggerStay(Collider col)
    {
        im.enabled = true;
        door_inform.enabled = true;
        if (col.tag == "Player") {
            if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space)) {
                im.enabled = false;
                door_inform.enabled = false;
                dooropen.SetBool("open", true);
                sound.SendMessage("enableSound");
                Destroy(enablespace);
            }
        }
    }

    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player") {
            im.enabled = false;
            door_inform.enabled = false;
        }        
    }
}
